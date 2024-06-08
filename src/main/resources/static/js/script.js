
function confirmDelete(itemId) {
    console.log("clicked!!!!")
    if (confirm("Are you sure you want to delete this item?")) {
        // Redirect to the delete URL with the item ID
        window.location.href = '/app/delete/' + itemId;
    }
}