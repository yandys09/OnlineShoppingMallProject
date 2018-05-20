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
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
});