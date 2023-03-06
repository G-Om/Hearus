const togglePass = document.getElementById('togglePassword')
console.log(togglePass)

const PassEl = document.getElementById('pass-el')
console.log(PassEl)


togglePass.addEventListener('click',function(){
    const type = PassEl.getAttribute("type") === "password" ? "text":"password";
    PassEl.setAttribute("type",type);

    this.classList.toggle("bi-eye")
})


const emailEl = document.getElementById('email-el')
const passEl = document.getElementById('pass-el')

emailEl.addEventListener('input',()=>{
    const Emailtext = document.getElementById('em-el')
    const emailValue =  /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{1,63}$/

    if(emailEl.value.match(emailValue)){
        Emailtext.classList.add('valid')
        Emailtext.classList.remove('invalid')
        Emailtext.innerHTML = "Your Email is Valid"

    }else{
        Emailtext.classList.add('invalid')
        Emailtext.classList.remove('valid')
        Emailtext.innerHTML = "Your Email is not Valid"

    }
    
})


// passEl.addEventListener('input',()=>{
//     const Passtext = document.getElementById('pass-el')
//     const pass = document.getElementById('pas-el')
//     const passValue =  /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/

//     if(Passtext.value.match(passValue)){
//         pass.classList.add('valid')
//         pass.classList.remove('invalid')

//     }else{
//         pass.classList.add('invalid')
//         pass.classList.remove('valid')
//         pass.innerHTML = "Your password must be at least 6 characters as well as contain at least one uppercase, one lowercase, and one number."

//     }
    
// })