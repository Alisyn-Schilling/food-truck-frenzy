const mapDiv = document.getElementById("map")

function initMap () {
    const location = { lat: latitude, lng: longitude };
    console.log(location)
    const map = new google.maps.Map(mapDiv, {
        zoom: 15,
        center: location,
    });
    const marker = new google.maps.Marker({ position: location, map: map });
}