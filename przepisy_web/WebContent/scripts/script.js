var componentsArray = [];
var qtaArray = [];
var addComponentButton = document.getElementById('addComponentButton');
var componentsJSON;
var qtaJSON;

var recipeId;

function addSelectedComponent() {
	var str = document.getElementById('componentComboBox').value;
	var qta = document.getElementById('componentsQta').value;
	componentsArray.push(str);
	qtaArray.push(qta);
	document.getElementById("componentsQty").innerHTML = qtaArray.length;
}

function componentsToJSON(){
	componentsJSON = JSON.stringify(componentsArray);
	document.getElementById("hiddenComponents").value = componentsJSON;
	
	qtaJSON = JSON.stringify(qtaArray);
	document.getElementById("hiddenQta").value = qtaJSON;
}

function getRecipeId(id){
	recipeId = id;
}

function setRecipeId(){
	document.getElementById("hiddenRecipeId").value = recipeId;
}