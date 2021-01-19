window.onload = function(){
	var reloading = sessionStorage.getItem("reloading");
	if (reloading) {
		sessionStorage.removeItem("reloading");
		setTimeout(function(){ 
		document.getElementById("componentAdd_addToBase").innerHTML = "";
		}, 5000);
	}
}