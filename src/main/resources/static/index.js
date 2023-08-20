function formToObject(formSelector) {
	const form = document.querySelector(formSelector);
	/* Lấy dữ liệu input */
	const obj = {};
	const inputs = form.querySelectorAll('input');
	
	for (const input of inputs) {
		const name = input.getAttribute('name');
		const value = input.value;
		obj[name] = value;
	}

	return obj;

}

function postFormData(path, formData) {
	return fetch(path, {
		method: 'POST',
		body: formData,
	}).then(response => response.json())
}

function post(path, body) {
	var myHeaders = new Headers();
	myHeaders.append('Content-Type', 'application/json');
	return fetch(path, {
		method: 'POST',
		body: JSON.stringify(body),
		headers: myHeaders
	}).then(response => response.json())
}

function put(path, body) {
	var myHeaders = new Headers();
	myHeaders.append('Content-Type', 'application/json');
	return fetch(path, {
		method: 'PUT',
		body: JSON.stringify(body),
		headers: myHeaders
	}).then(response => response.json())
}

function callDelete(path, body = {}) {
	var myHeaders = new Headers();
	myHeaders.append('Content-Type', 'application/json');
	return fetch(path, {
		method: 'DELETE',
		body: JSON.stringify(body),
		headers: myHeaders
	})
}

function get(path, params = {}) {
	var myHeaders = new Headers();
	myHeaders.append('Content-Type', 'application/json');
	const paramUrl = new URLSearchParams(params);
	return fetch(`${path}?${paramUrl}`, {
		method: 'GET',
		headers: myHeaders,
	}).then(response => response.json())
}