var componentsArray = [];
var componentsNames = [];
var qtaArray = [];
var addComponentButton = document.getElementById('addComponentButton');
var componentsJSON;
var qtaJSON;

var componentName;
var recipeId;

function addSelectedComponent() {
	var str = document.getElementById('componentComboBox').value;
	var qta = document.getElementById('componentsQta').value;
	var comboBox = document.getElementById('componentComboBox');
	
	componentName = comboBox.options[comboBox.selectedIndex].text;
	
	componentsArray.push(str);
	qtaArray.push(qta);
	document.getElementById("componentsQty").innerHTML = qtaArray.length;
	
	var componentPlusQta = componentName.concat(" - ", qta);
	
	var option = document.createElement("option");
	option.innerHTML = componentPlusQta;
	document.getElementById("addedComponentsList").appendChild(option);
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