

async function getLocation() {
    let rawResponse = await fetch("http://localhost:8080/hearus/emergency/fetchL");
    let location = await rawResponse.json();

    if(location != null)
    {
        // console.log(location.longitude)


        var myLat = (location.latitude);
        var myLong = (location.longitude);

        var coords = new google.maps.LatLng(myLat, myLong);

        var mapOptions = {
            zoom: 14,
            center: coords,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }

        var map = new google.maps.Map(document.getElementById("map"), mapOptions);

        var marker = new google.maps.Marker({map:map, position: coords});
        console.log(myLong,myLat);

    }
}

getLocation().catch(e=>{console.log(e)})
// async function check() {
//     if (location == null) {
//         getLocation().catch(e => {
//             console.log(e)
//         })
//     }
// }
setInterval(getLocation,3000);

