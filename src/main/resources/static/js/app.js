function myFunction() {
  var x = document.getElementById("PassWord");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}