var componentsArray = [];
var addComponentButton = document.getElementById('addComponentButton');
var componentsJSON;

function addSelectedComponent() {
	var str = document.getElementById('componentComboBox').value;
	componentsArray.push(str);
	alert("Pomyslnie dodano skladnik. Mozesz dodac nastepny.");
	document.getElementById("componentsQty").innerHTML = componentsArray.length;
}

function componentsToJSON(){
	componentsJSON = JSON.stringify(componentsArray);
	document.getElementById("hiddenComponents").value = componentsJSON;
}