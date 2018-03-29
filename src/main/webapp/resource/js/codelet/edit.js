$(document).ready(function(e) {
	ace.require("ace/ext/language_tools");
	var editorAce1 = ace.edit("code1");
	var textarea = $("#txta");

	editorAce1.getSession().on('change', function() {
		textarea.val(editorAce1.getSession().getValue());
	});
	textarea.val(editorAce1.getSession().getValue());
	editorAce1.setReadOnly(false);
	editorAce1.focus();
	editorAce1.setOptions({
		enableBasicAutocompletion : true,
		enableSnippets : true,
		enableLiveAutocompletion : true
	});

	var language = "";
	var modeset = "";

	language = $("#languageCode").val();
	modeset = "ace/mode/" + language;
	editorAce1.getSession().setMode(modeset);

	editorAce1.setTheme("ace/theme/monokai");

});
