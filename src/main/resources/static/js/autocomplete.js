function initAutocomplete() {
    // Create the autocomplete object, restricting the search predictions to
    // geographical location types.
    autocomplete = new google.maps.places.Autocomplete(
        document.getElementById("autocomplete"),
        { types: ["geocode"] }
    );
    // Avoid paying for data that you don't need by restricting the set of
    // place fields that are returned to just the address components.
    autocomplete.setFields(["address_component", "geometry"]);

    // When the user selects an address from the drop-down, populate the
    // address fields in the form.
    autocomplete.addListener("place_changed", fillInCoordinates);
    initMap();
}

function fillInCoordinates() {
    // Get the place details from the autocomplete object.
    const place = autocomplete.getPlace();
    const latField = document.getElementById("latitude");
    const lngField = document.getElementById("longitude");
    latField.value = "" + place.geometry.location.lat();
    lngField.value = "" + place.geometry.location.lng()

    // Get each component of the address from the place details,
    // and then fill-in the corresponding field on the form.


    // initMap(place.geometry.location.lat(), place.geometry.location.lng());
}

function geolocate() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            const geolocation = {
                lat: position.coords.latitude,
                lng: position.coords.longitude,
            };
            const circle = new google.maps.Circle({
                center: geolocation,
                radius: position.coords.accuracy,
            });
            autocomplete.setBounds(circle.getBounds());
        });
    }
}

const mapDiv = document.getElementById("map")

function initMap () {
    const location = { lat: latitude, lng: longitude };
    const map = new google.maps.Map(mapDiv, {
        zoom: 15,
        center: location,
    });
    const marker = new google.maps.Marker({ position: location, map: map });
}