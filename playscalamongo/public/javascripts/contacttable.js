(function($){
	$(document).ready(function() {
		$('#btndelete').click(function() {
			$('#confirmdelete').dialog();
		});

		$('#myTable').tablesorter({
			headers : {
				2 : {
					sorter : false
				}
			}
		});
		
		
		$('#confirmdelete').dialog({
			autoOpen: false,
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			}
		});
		

	});
})(jQuery);