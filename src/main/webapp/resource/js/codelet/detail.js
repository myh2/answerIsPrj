$(document).ready(function(e) {
      ace.require("ace/ext/language_tools");
      var editorAce1 = ace.edit("code1");
      var textarea = $("#txta");

      editorAce1.getSession().on('change', function() {
         textarea.val(editorAce1.getSession().getValue());
      });
      textarea.val(editorAce1.getSession().getValue());
      editorAce1.setReadOnly(true);
      editorAce1.focus();
      editorAce1.setOptions({
         enableBasicAutocompletion : true,
         enableSnippets : true,
         enableLiveAutocompletion : true,
         maxLines:Infinity
         
      });

      var language = "";
      var modeset = "";


      language = $("#languageCode").val();
      modeset = "ace/mode/" + language;
      editorAce1.getSession().setMode(modeset);
      editorAce1.setTheme("ace/theme/monokai");
      
//----------클립보드----------------------------------------------   
      
      $("#copy-button").click(function(){
         
         var copytext = $("<textarea>");
         
            $("main").append(copytext);
            copytext.val(editorAce1.getSession().getValue()).select();
            document.execCommand("copy");
            copytext.remove();
            alert("클립보드로 복사되었습니다");
         
      });
      

       $("#langlist-button").click(function(event) {
         
         $("#drop-menu").slideToggle(400);
         
       });

       /*---------------------------------즐겨찾기---------------------------------*/
       //노드 선택
       var favButton=$("#fav");
       //선택된 노드의 이벤트 조작
       favButton.click(function(event){
       	var favVal=$(event.target).next().text();
       	var code=$(event.target).next().next().text();
       	var l=null;
       	//ajax post요청으로 db에 접근하여 db를 수정한다.
       	$.ajax({
       		  method: "POST",
       		  url: "favorites",
       		  data: {"code":code,
       			  "data":favVal },
       		  dataType:"text"
       		});

       	//기존의 노드를 삭제한다
       	$(event.target).next().remove();
       	
       	//ajax의 json을 이용하여 데이터를 얻어온다.
       		$.ajax({ 
       			dataType:"json",
       			url:"codeletJSON",
       			data:{"code":code},
       			success:function(data){
       			 l=eval(data);
       			 //tag를 생성하여 불러온 data를 저장한다.
       			 var tag="<span class='hidden'>"+l[0].favorite+"</span>";
       			 //생성한 tag를 붙여준다.
       			 $(event.target).after(tag);
       			 if(l[0].favorite=="N"){
       				 $(event.target).removeClass("glyphicon glyphicon-star").addClass("glyphicon glyphicon-star-empty");
       				 
       			 }
       			 else if(l[0].favorite=="Y"){
       				 $(event.target).removeClass("glyphicon glyphicon-star-empty").addClass("glyphicon glyphicon-star");
       				 
       			 }
       			}
       		});
       	
       		
       		
       	});
       
/*-----------즐겨찾기 버튼의 배경화면 바꿔주기 --------------*/
      var favVal=$("#fav").next().text();
      
      if(favVal==="Y"){
    	 favButton.removeClass("glyphicon glyphicon-star-empty").addClass("glyphicon glyphicon-star");
      }
      
      else if(favVal==="N"){
    	  favButton.removeClass("glyphicon glyphicon-star").addClass("glyphicon glyphicon-star-empty");
      }
});