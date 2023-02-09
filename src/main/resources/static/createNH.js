const submitBtn = document.getElementById("submit-btn");
const passwordInput = document.getElementById("password");
const initialsInput = document.getElementById("initials");
const nameInput = document.getElementById("name");
const phoneInput = document.getElementById("phone-number");
const streetInput = document.getElementById("street");
const cityInput = document.getElementById("city");
const stateInput = document.getElementById("state");
const zipcodeInput = document.getElementById("zipcode");
const jobInput = document.getElementById("job")
const jobDropdown = document.getElementById("job-dropdown");
const salaryDropdown = document.getElementById("salary-dropdown");
const deptDropdown = document.getElementById("dept-dropdown");
const managerDropdown = document.getElementById("manager-dropdown");


function generatePassword(length) {
    const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':\"<>,.?/\\";
    let password = "";
    for (let i = 0; i < length; i++) {
      password += charset.charAt(Math.floor(Math.random() * charset.length));
    }
    return password;
  }
  

function generateNumbers(){
    numbers = '';
    for(let i = 0; i < 3; i++){
       number = Math.floor(Math.random() * 10);
       number.toString();
        numbers += number
    }
    //console.log("numbers:" + numbers)
    return numbers;
    
}

function generateEmail(initials){
    let numbers = generateNumbers();
     autoEmail = initials.toLowerCase() + numbers + "@trakd.com";

     //console.log("autoEmail:" + autoEmail)
     return autoEmail;
}

async function saveNewHire(){
    passwordInput.value = generatePassword(8);
    let finalPassword = passwordInput.value
    let finalEmail = generateEmail(initialsInput.value);
    let finalName = nameInput.value;
    let finalPhone = phoneInput.value;
    let finalStreet = streetInput.value;
    let finalCity = cityInput.value;
    let finalState = stateInput.value;
    let finalZipcode = zipcodeInput.value;
    let selectedJob = jobDropdown.options[jobDropdown.selectedIndex].value;
    let selectedSalary = salaryDropdown.options[salaryDropdown.selectedIndex].value;
    let selectedDept = deptDropdown.options[deptDropdown.selectedIndex].value;
    let selectedManager = managerDropdown.options[managerDropdown.selectedIndex].value;

    let data = {"name": finalName,
    "email": finalEmail,
    "jobTitle": selectedJob,
    "password": finalPassword,
    "salary": selectedSalary,
    "dept_id": selectedDept,
    "manager_id": selectedManager
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

