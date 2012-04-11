(function($){
	$(document).ready(function() {
		viewMode();		

		function viewMode() {
			$('.contactfield').each(function(){$(this).attr('readonly',true)});
			$('#btnSave').css('display','none');
			$('#btnCancel').css('display','none');
			$('#btnEdit').css('display','inline');
			$('#btnDelete').css('display','inline');
			$('#btnBack').css('display','inline');	
		}

		function editMode(roflag) {
			$('.contactfield').each(function(){$(this).attr('readonly',roflag)});
			$('#btnSave').css('display','inline');
			$('#btnCancel').css('display','inline');
			$('#btnEdit').css('display','none');
			$('#btnDelete').css('display','none');
			$('#btnBack').css('display','none');	
		}

		$('#btnSave').click(function() {
			viewMode();
		});

		$('#btnCancel').click(function() {
			viewMode();
		});
		
		$('#btnEdit').click(function() {
			$('#btnSave').attr('value','Save')
			editMode(false);
		});

		$('#btnDelete').click(function() {
			$('#btnSave').attr('value','Delete')			
			editMode(true);
		});	
		
	});
})(jQuery);