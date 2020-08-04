function initMap() {
    const location = { lat: latitude, lng: longitude };
    console.log(location)
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 15,
        center: location,
    });
    const marker = new google.maps.Marker({ position: location, map: map });
}