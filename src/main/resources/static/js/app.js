function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";

  } else {
    x.type = "password";
  }
}
function Confirm(){
	confirm("Do you want to add this item to your cart");
}
function ClickAdd(name) {
  alert("Add "+ name +" to cart!");
}
function GenerateID(ID){
	alert("Your Group ID is: "+ID);
}



