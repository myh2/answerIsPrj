/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.toolbarGroups = [
//		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
//		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
//		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles'] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'align','paragraph' ] },
		{ name: 'links', groups: [ 'links' ] },
//		{ name: 'tools', groups: [ 'tools' ] },
//		{ name: 'about', groups: [ 'about' ] },
//		{ name: 'document', groups: [ 'mode'] },
		{ name: 'others', groups: [ 'others' ] }
	];
	
	config.removeButtons = 'Unlink,Anchor,Flash,Smiley,SpecialChar,PageBreak,Iframe,Format,ShowBlocks,NewPage,Preview,Print,Styles';

	
	config.uiColor = '#ff9900';
};