$(document).ready(function(e) { 
	ace.require("ace/ext/language_tools");
	var editorAce1 = ace.edit("code1");
	var textarea = $("#txta");

	editorAce1.getSession().on('change', function() {
		textarea.val(editorAce1.getSession().getValue());
	});
	textarea.val(editorAce1.getSession().getValue());

	editorAce1.focus();
	editorAce1.setOptions({
		enableBasicAutocompletion : true,
		enableSnippets : true,
		enableLiveAutocompletion : true
	});

	var language = "";
	var modeset = "";

	$("#languageCode").on("change", function() {
		if(  $("#languageCode").val() == "JSP" ||  $("#languageCode").val() == "Django" )
			language = "html";
		else
			language = $("#languageCode").val();
		modeset = "ace/mode/" + language;
		editorAce1.getSession().setMode(modeset);
	});

	editorAce1.setTheme("ace/theme/monokai");
	
	/*
	 * 수정일 경우 언어선택 초기화
	 * */
	if( $("#languageCode").val != '' ) {	
		language = $("#languageCode").val();
		modeset = "ace/mode/" + language;
		editorAce1.getSession().setMode(modeset);
	}
	
	/*
	 * 나의 태그 조회하기
	 * */	
	//tag list by Ajax n Json
	var myTagBtn = $("#div-tag input[name='btn-myTag']");
	//var tagListDiv = $("#div-tag div:last-child");
   //	/div-myTagList
	var tagListDiv = $("#div-myTagList");
	
	myTagBtn.click(function( ){
		
		$.getJSON("codelet-hashTags", function( data ){
			var myHashtags ="";
			for( var i = 0; i<data.length; i++){
				myHashtags += "<a href=\"javascript:fncAddTag('"+data[i].hashTag+"');\">" + data[i].hashTag +"</a>";
				//myHashtags += "<a href='javascript:void(0)' id='"+data[i].hashTag+"'>" + data[i].hashTag +"</a>"; 				
				if( i != data.length-1 ) myHashtags += ", ";
			}
			var style = {
					width:"100%",
					height:"auto",
					"background-color":"white",
					border:"1px solid gray"					
			}
			tagListDiv.css(style);			
//			alert( myHashtags );
			tagListDiv.html( myHashtags );
		});
	});
	
	//--Input Multipul hashtags start ----------------------------------------------
    function split( val ) {
    	var tagRep =  val.replace(/#/gi,"").trim().split( /,\s*/ );//#삭제, 공백삭제,comma로 split
		return tagRep; 
    }
    function extractLast( term ) {
		return split( term ).pop();//return last element
    }
    function cleanArray(actual) {
        var newArray = new Array();
        for(var i = 0; i<actual.length; i++){
            if (actual[i] )
            {
                newArray.push(actual[i]);
            }
        }
        return newArray;
    }    
 
    function unique(array) {
    	var result = [];
    	$.each(array, function(index, element) {     // 배열의 원소수만큼 반복
    		if ($.inArray(element, result) == -1) {  // result 에서 값을 찾는다.  //값이 없을경우(-1)
    			result.push(element);                // result 배열에 값을 넣는다.
    		}
    	});
    	return result;
    }
    
    var tagInput = $("#hashTag");
	 $("#hashTag").on("click",function(){
			if( tagInput.val() == "" )
				tagInput.val("#");
	});
	 
	 ///-----------------------------------
    $( "#hashTag" ).on( "keydown", function( event ) {

    	if ( event.keyCode === $.ui.keyCode.TAB && $( this ).autocomplete( "instance" ).menu.active ) {
        	event.preventDefault();
        }
        
        $("#hashTag").autocomplete({
            minLength: 2,
            source: function( request, response ) {

            	var dataArray = [ ];
             	$.getJSON("codelet-hashTags?userFlag=A&ht="+ extractLast( request.term ), function( data ){
             		//alert( data );
    	   			for( var i = 0; i<data.length; i++){
    	   				dataArray[i] = data[i].hashTag;
        			}	   			 

    		        response( dataArray );
       			});//end json

            },
            focus: function() {
              // prevent value inserted on focus
              return false;
            },
            select: function( event, ui ) {
            	var terms =  split(this.value );
    	        terms.pop();
    	        terms.push( ui.item.value );
    	        terms.push( "" );
    	        //중복제거, 빈배열 삭제
    	        terms = unique(cleanArray( terms ));
    	        this.value = "#" +  terms.join( ", #" );
    	        return false;
            }
          });	
      });

    $( "#hashTag" ).on( "keyup", function( event ) {
		var tagInputOrg = $("#hashTag").val();
		
		var terms =  split(tagInputOrg );
		 terms = unique(cleanArray( terms ));
		 var newTerms = "#" +  terms.join( ", #" ) +  ", #";
		
		if( event.which == "188" ){ //쉼표 입력때마다 " #" 입력			
			$("#hashTag").val( newTerms );
		}else if( event.which == "32" ){ //space 때마다 , # 덧붙여주기
			$("#hashTag").val( newTerms );
		}
    });
    
	//--End input multiful hashtags-------------------------------
    
    $("#btn-save").on( "click", function(){
    	var language = $("#languageCode");
    	var textarea = $("#txta");
    	var title = $("#title");
    	
    	//tag validation check
		var tagInputOrg = $("#hashTag").val();		
		var terms =  split(tagInputOrg );
		 terms = unique(cleanArray( terms ));		 
		 var newTerms="#" +  terms.join( ", #" );
		 //alert("---"+newTerms+"---");
		 $("#hashTag").val( newTerms );

    	if( language.val().trim() == "" ){
    		alert( "언어선택이 없습니다. 선택해주세요.");
    		language.focus();
    		return;
    	}

    	if( title.val().trim() == "" ){
    		alert( "제목이 없습니다. 입력해주세요.");
    		title.focus();
    		return;
    	}

    	if( textarea.val().trim() == "" ){
    		alert( "Code가 없습니다. 입력해주세요.");
    		ace.edit("code1").focus();
    		return;
    	}
    	
    	//저장하기
    	if( $("#currentAction").val() == "U" )
    		$("#target").attr("action","codelet-edit");
    	else if( $("#currentAction").val() == "R" )
    		$("#target").attr("action","codelet-reg");

    	$('#target').submit();
    	  
    });
    
});

/*
 * 나의 태그 입력폼에 태그 추가하기
 * */
function fncAddTag( ht ){
	var tagInput = $("#div-tag input[name='hashTag']");
	var inputValue= tagInput.val();
	var inputValueLen = inputValue.split(",").length;
	
	if( inputValueLen == 10 ){
		alert( "태그는 10개까지 입력 가능합니다.")
		return;
	}

	if( inputValue.replace(" ","") == '' )
		tagInput.val("#" + ht );
	else
		tagInput.val( inputValue + ", #" + ht );
}