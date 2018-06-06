$(function(){
	
	switch(menu){
	case 'About US':
		$('#about').addClass('active');
		break;
	case 'Contact US':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addclass('active');
		break;
	default:
		if (menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	//code for jquery dataTable
	//create a dataset
	var products = [
			['1', 'ABC'],
			['2', 'CYX'],
			['3', 'XYZ'],
			['4', 'ZZY'],
			['5', 'AAB'],
			['6', 'BBC'],
			['7', 'CCA'],
			['8', 'CDE'],
			['9', 'FGH'],
			['10', 'HGG'],
			['11', 'FFG']
		
	];
	
	var $table = $('#productListTable');
	
	//execute the below code only where we have this table
	if($table.length){
		//console.log('Inside the table!');
		
		$table.DataTable({
			lengthMenu:[[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All Records']],
			pageLength: 5,
			data:products
		});
		
		
	}
});