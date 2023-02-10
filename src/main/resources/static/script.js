const submitBtn = document.getElementById("submit-btn");
const passwordInput = document.getElementById("password");
const initialsInput = document.getElementById("initials");
const employeeIdInput = document.getElementById("employee-id");
const nameInput = document.getElementById("name");
const jobInput = document.getElementById("job-dropdown");
const salaryInput = document.getElementById("salary-dropdown");

function generatePassword(length) {
    const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':\"<>,.?/\\";
    let password = "";
    for (let i = 0; i < length; i++) {
        password += charset.charAt(Math.floor(Math.random() * charset.length));
    }
    return password;
}


function generateEmployeeId(){
    numbers = '';
    for(let i = 0; i < 6; i++){
        number = Math.floor(Math.random() * 10);
        number.toString();
        numbers += number
    }
    //console.log("numbers:" + numbers)
    return numbers;

}

let employeeId = generateEmployeeId();

function generateEmail(initials){
    let autoEmail = initials.toLowerCase() + employeeId + "@trakd.com";
    //console.log("autoEmail:" + autoEmail)
    return autoEmail;
}

function saveNewHire(){
    passwordInput.value = generatePassword(8);
    employeeIdInput.value = employeeId;

    let finalPassword = passwordInput.value
    let finalEmployeeId = employeeIdInput.value
    let finalEmail = generateEmail(initialsInput.value);
    let finalName = nameInput.value;
    let selectedJob = jobInput.value;
    let selectedSalary = salaryInput.value;


    let data = {
        "employeeId": finalEmployeeId,
        "name": finalName,
        "email": finalEmail,
        "employeeId": finalEmployeeId,
        "jobTitle": selectedJob,
        "password": finalPassword,
        "job_title": selectedSalary,
        "salary": selectedSalary
    }

    let url = "http://localhost:8080/newhire/create"

    fetch(url, {
        method:"POST",
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (response.ok){
                console.log("success!")
            } else {
                throw new Error("did not create newhire")
            }
        })
        .catch(error => {
            console.log(error)
        });
}

submitBtn.addEventListener("click" , (e) => {
    e.preventDefault();
    saveNewHire();
})

