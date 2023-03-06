x = navigator.geolocation;
x.getCurrentPosition(success,failure);
let latitude = null;
let longitude = null;
function success(position){
    latitude = position.coords.latitude;
    longitude = position.coords.longitude;
}
function failure(){}

const cancel = document.getElementById("");
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

cancel.addEventListener("click",sendLocation);