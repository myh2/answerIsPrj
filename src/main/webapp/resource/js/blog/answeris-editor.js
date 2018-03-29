function initEditor(selector){
	var textarea = $(selector);
	var editorDiv = $("<div />");
	textarea.before(editorDiv);
	
	editorDiv.load("../resource/js/blog/res/answeris-editor.html", function(){
	
		var editableDiv= $(".editable-div");
		editableDiv.keyup(function(){
			textarea.val(editableDiv.html());
		});
		
		$(".italic-button").click(function(event){
			document.execCommand("italic");
		});
		$(".bold-button").click(function(event){
			document.execCommand("bold");
		});
		$(".underline-button").click(function(event){
			document.execCommand("underline");
		});
		$(".font-size-button").click(function(){
			document.execCommand("fontSize",false, $(".font-size-button").val());
		});
		$(".font-style-button").click(function(){
			document.execCommand("fontName", false, $(".font-style-button").val());
		});
		$(".codelet-reg-button").click(function(){
			var codeData;
			var codelet = "<div id=code1>"+"</div>";
			document.execCommand("insertHTML", null, codelet);
		});
		$(".codelet-call-button").click(function(flag){
			var codeletSrc;
			var codelet;
			codeletSrc="";
			codelet = '<div class="replace-codelet">'+'</div>';
			document.execCommand("insertHTML", null, codelet);
			$(".dialog-background-cover").css("display", "block");
			$(".codelet-dialog-box").css("visibility", "visible");
			var getList=function(flag){
				if(!(flag =="F" || flag=="R"))
					flag="";
				
				$.getJSON("../codeletJSONAjax?sortFlag="+flag, function(data){
					var tbody=$("#codelet-list tbody");
					tbody.empty();
					
					for(var i=0; i<data.length; i++){
						var tr=$('<tr>\
								<td class="codelet-title" ><input type="hidden" /><span></span></td>\
								<td class="codelet-hashTag" ></td>\
								<td class="codelet-languageCode" ></td>\
								<td class="codelet-codeSrc"><textarea></textarea></td>\
							</tr>');
						tr.appendTo(tbody);
						tr.find(".codelet-title input").val(data[i].code);
						tr.find(".codelet-title span").text(data[i].title);
						tr.find(".codelet-hashTag").text(data[i].hashTag);
						tr.find(".codelet-languageCode").text(data[i].languageCode);
						tr.find(".codelet-codeSrc textarea").val(data[i].codeSrc);
					}			
				});
			};
			getList();
			
			$(".recent-reg").click(function(){
				getList();				
			});
			$(".favorite").click(function(){
				getList("F");
			});
			$(".recent-view").click(function(){
				getList("R");
			});
			
			$("#codelet-list tbody").click(function(event){
				var target;
				if($(event.target).is("tr"))
					target=$(event.target);
				else
					target=$(event.target).parents("tr");
				event.stopPropagation();
				target.find("td").css("border", "2px solid blue");
				codeletSrc = target.find(".codelet-codeSrc textarea").val();
			});
			$(".btn-OK").click(function(){
				$(".dialog-background-cover").css("display", "none");
				$(".codelet-dialog-box").css("visibility", "hidden");
				if(codeletSrc==""){
					$(".replace-codelet").remove();
				}else{
					codelet = '<div id="code">'+codeletSrc+"</div>";
					$(".replace-codelet").replaceWith(codelet);
					codeletSrc="";
				};
			});
			
			$(".codelet-dialog-box input[value='cancel']").click(function(){
				$(".dialog-background-cover").css("display", "none");
				$(".codelet-dialog-box").css("visibility", "hidden");
				$(".replace-codelet").remove();
			});
						
		});
		$(".img-button").click(function(){
			document.execCommand("insertImage", null, "/AnswerisPrj/resource/images/logo.png");
		});
		
		editableDiv.click(function(){
			if(editableDiv.text()=="탭하여 글 작성")
				editableDiv.text("");
		});
		editableDiv.focusout(function(){
			if(editableDiv.text()=="")
				editableDiv.text("탭하여 글 작성");
		});		
		
	});
};

