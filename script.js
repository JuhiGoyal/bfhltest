document.getElementById("bfhlForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  // Show loading alert
  showAlert('Loading...', 'info');

  const data = document.getElementById("dataInput").value.split(",").map(s => s.trim());
  const fileInput = document.getElementById("fileInput").files[0];

  let file_b64 = "";
  if (fileInput) {
    const reader = new FileReader();
    reader.onloadend = async function () {
      file_b64 = reader.result.split(",")[1];
      await sendRequest(data, file_b64);
    };
    reader.readAsDataURL(fileInput);
  } else {
    await sendRequest(data, "");
  }

  async function sendRequest(data, file_b64) {
    try {
      const response = await fetch("http://localhost:8080/bfhl", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ data, file_b64 })
      });

      if (response.ok) {
        const result = await response.json();
        showAlert('Data submitted successfully!', 'success');
        document.getElementById("response").textContent = JSON.stringify(result, null, 2);
        document.getElementById("error").textContent = ""; // Clear error message
      } else {
        const error = await response.json();
        showAlert(`Error: ${error.message || 'Something went wrong'}`, 'error');
      }
    } catch (error) {
      showAlert('Network error: Please try again later.', 'error');
    }
  }

  function showAlert(message, type) {
    const alertBox = document.createElement('div');
    alertBox.classList.add('alert');
    if (type === 'success') {
      alertBox.classList.add('alert-success');
    } else if (type === 'error') {
      alertBox.classList.add('alert-error');
    } else {
      alertBox.classList.add('alert-info');
    }
    alertBox.textContent = message;
    document.body.prepend(alertBox);
    setTimeout(() => alertBox.remove(), 5000);
  }
});
