const editButton = document.createElement('Button');
editButton.innerHTML='Edit';
editButton.addEventListener('click', ()=> {
    editButtonFunction();
})

const editButtonFunction()=>{
    <div class="vendor-edit-form">
        <form action="/locations" method="POST">
            <div class="vendor-input-form">
                <input type="hidden" th:value="${vendors.id}" name="vendorId" required/>
                <input name="address" id="autocomplete" type="text" placeholder="Enter Address" onFocus="geolocate()"
                       required/>
                <input type="hidden" name="latitude" id="latitude" required/>
                <input type="hidden" name="longitude" id="longitude" required/>
                <input type="date" name="date" required/>
                <input type="text" name="openHours" placeholder="Open Hours" required/>
                <label for="recurring">Recurring Weekly:</label>
                <input name="recurring" type="checkbox" id="recurring"/>
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
}