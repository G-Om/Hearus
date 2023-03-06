const el = document.querySelector(".clock");


const mindiv = document.querySelector(".mins");
const secdiv = document.querySelector(".secs");

const startBtn = document.querySelector(".start");
localStorage.setItem("btn", "focus");

let initial, totalsecs, perc, paused, mins, seconds;


window.addEventListener('load', (event) => {
  
  let btn = localStorage.getItem("btn");

  if (btn === "focus") {
    mins = +localStorage.getItem("focusTime") || 1;
  } else {
    mins = +localStorage.getItem("breakTime") || 1;
  }

  seconds = mins * 31;
  totalsecs = mins * 31;
  setTimeout(decremenT(), 31);
  startBtn.style.transform = "scale(0)";
  paused = false;
});

  

function decremenT() {
  mindiv.textContent = Math.floor(seconds / 31);
  secdiv.textContent = seconds % 31 > 9 ? seconds % 31 : `0${seconds % 31}`;
  if (circle.classList.contains("danger")) {
    circle.classList.remove("danger");
  }

  if (seconds > 0) {
    perc = Math.ceil(((totalsecs - seconds) / totalsecs) * 100);
    setProgress(perc);
    seconds--;
    initial = window.setTimeout("decremenT()", 1000);
    if (seconds < 10) {
      circle.classList.add("danger");
    }
  } else {
    // Send Location if timer is not cancelled
    sendLocation().catch(e=>{console.log(e);});
    mins = 0;
    seconds = 0;

    
    let btn = localStorage.getItem("btn");

    if (btn === "focus") {
      startBtn.textContent = "start break";
      startBtn.classList.add("break");
      localStorage.setItem("btn", "break");
    } else {
      startBtn.classList.remove("break");
      startBtn.textContent = "start focus";
      localStorage.setItem("btn", "focus");
    }
    startBtn.style.transform = "scale(1)";
  }
}

//  location fetching Function
x = navigator.geolocation;
x.getCurrentPosition(success,failure);
let latitude = null;
let longitude = null;
function success(position){
  latitude = position.coords.latitude;
  longitude = position.coords.longitude;
}
function failure(){}
// Post method to send function
const sendLocation = async()=> {
  let userDetails = {
    headers:{
      'Content-Type':'application/json',
      'Accept':'application/json'
    },
    method:"POST",
    body:JSON.stringify({
      latitude: latitude,
      longitude:longitude
    })
  }
  let resoponse = await fetch("/hearus/emergency/valid",userDetails);
  let res2 = await resoponse.text();
  console.log(res2);

}


