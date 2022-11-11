import React, { useState } from 'react';
import axios from 'axios';
import styles from '../Login-Page/login.module.css';
import { Link } from 'react-router-dom';

function RegisterLandlord(){
    let initialuser={userId:0,userName:'',password:'',userType:'landlord'};
    let [user,setUser]=useState(initialuser);
    // const [formErrors, setFormErrors] = useState({});
    // const [isSubmit, setIsSubmit] = useState(false);

    let initiallandlord={flatList:[], landlordAge: 0, landlordId: 0, landlordName: ''};
    let [landlord,setLandlord]=useState(initiallandlord);

      function handleLandlord(e)
        {
            e.preventDefault();
            console.log(landlord);
            const URL1='http://localhost:8080/users/addUser';
            axios.post(URL1,user).then((response) => 
            {                    
                setUser(initialuser);
            }).catch(error => console.log(error.message))    

            const URL2='http://localhost:8080/landlord/addlandlord';
            axios.post(URL2,landlord).then((response) => 
            {
                setLandlord(initiallandlord);
            }).catch(error => console.log(error.message))
            window.alert("Landlord Registered...");
        }
    
    
    
    return (
        <React.Fragment>
            <form className="c2" method="POST">
            <h1 className="form-text ">Register Landlord</h1>
             <br/><br/><br/><br/>
             <label>Username</label>
            <input name="username" type="text" placeholder="Username*" className="username"
             value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
            />
            {/* <p>{formErrors.userName}</p> */}
            <br/>
            <label>Password</label>
            <input name="password" type="password" placeholder="Password*" className="username"
            value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
            />
            {/* <p>{formErrors.password}</p> */}
            <br/>
            <label>Landlord Name</label>
            <input name="landlordname" type="text" placeholder="Landlord Name" className="username"
            value={landlord.landlordName} onChange={e=>setLandlord({...landlord,landlordName:e.target.value})}/>
            <label>Landlord Age</label>
            <input name="landlordeage" type="number" placeholder="Landlord Age" className="username"
            value={landlord.landlordAge} onChange={e=>setLandlord({...landlord,landlordAge:e.target.value})}/>
            <br/>
            <button className="btn" type="submit" onClick={handleLandlord}>Register Landlord</button>
            </form>
        </React.Fragment>
    )
}

export default RegisterLandlord