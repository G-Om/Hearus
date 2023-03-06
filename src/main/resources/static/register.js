const emailEl = document.getElementById("em-el");
const passEl = document.getElementById("pass-el");
const spanPassTxt = document.getElementById("span-pas-el");
const conPassEl = document.getElementById("conPass-el");
const conSpanPassEl = document.getElementById("con-pas-el");
const emailSpanEl = document.getElementById("em-span-el");
const form = document.getElementById("form");



const togglePass = document.getElementById("togglePassword");
console.log(togglePass);

togglePass.addEventListener("click", function () {
	const type = passEl.getAttribute("type") === "password" ? "text" : "password";
	passEl.setAttribute("type", type);

	this.classList.toggle("bi-eye");
});

emailEl.addEventListener("input", () => {
	const spanEmail = document.getElementById("em-span-el");
	const emailValue = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$/;

	if (emailEl.value.match(emailValue)) {
		spanEmail.classList.add("valid");
		spanEmail.classList.remove("invalid");
		spanEmail.innerHTML = "Your email is valid";
	} else {
		spanEmail.classList.add("invalid");
		spanEmail.classList.remove("valid");
		spanEmail.innerHTML = "Your email is not valid";
	}
});

// const pass1 = passEl.value.trim();
// const pass2 = conPassEl.value.trim();

passEl.addEventListener("input", () => {
	const passExample = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
	if (passEl.value.match(passExample)) {
		spanPassTxt.classList.add("valid");
		spanPassTxt.classList.remove("invalid");
		spanPassTxt.innerHTML = "";
	} else {
		spanPassTxt.classList.add("invalid");
		spanPassTxt.classList.remove("valid");
		spanPassTxt.innerHTML ="Your password must be at least 6 characters as well as contain at least one uppercase, one lowercase, and one number.";
	}
});




// conPassEl.addEventListener('input',()=>{
//     if(pass2 !== pass1){
//         conSpanPassEl.classList.add("invalid")
//         conSpanPassEl.classList.remove("valid")
//         conSpanPassEl.innerHTML = "Paswword doesn't  match!!"
//     }
//     else{
//         conSpanPassEl.classList.add("valid")
//         conSpanPassEl.classList.remove("invalid")
//         conSpanPassEl.innerHTML = "Password match"
//     }
// })
