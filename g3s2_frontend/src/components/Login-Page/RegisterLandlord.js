import React, { useState , useEffect } from 'react';
import axios from 'axios';
import styles from '../Login-Page/login.module.css';
import { Link } from 'react-router-dom';

function RegisterLandlord(){
    let initialuser={userId:0,userName:'',password:'',userType:'landlord'};
    let [formValues,setUser]=useState(initialuser);
    
    const [formErrors,setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

    const handleSubmit = (e) =>{
        e.preventDefault();
        setFormErrors(validate(formValues));
        setIsSubmit(true);
    };
    useEffect(()=>{
        console.log(formErrors);
        if(Object.keys(formErrors).length===0 && isSubmit){
            console.log(formValues);
        }

    },[formErrors])
    const validate = (values) =>{
        const errors ={}
        if(!values.name){
            errors.userName = "Username is Required"
        }
        if(!values.landlordName){
            errors.landlordName = "Landlord Name is Required"
        }
        if(!values.landlordAge){
            errors.landlordAge = "Landlord Age is Required"
        }
        return errors;
    };

    let initiallandlord={flatList:[], landlordAge: 0, landlordId: 0, landlordName: ''};
    let [landlord,setLandlord]=useState(initiallandlord);
    

      function handleLandlord(e)
        {
            e.preventDefault();
            console.log(landlord);
            const URL1='http://localhost:8080/users/addUser';
            axios.post(URL1,formValues).then((response) => 
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
            <div>
            <form className="c2" method="POST" onSubmit = {handleSubmit}>
            <h1 className="form-text ">Register Landlord</h1>
             <br/><br/><br/><br/>
             
             <label>Username</label>
            <input name="username" type="text" placeholder="Username*" className="username"
             value={formValues.userName} onChange={e=>setUser({...formValues,userName:e.target.value})} />
            <p>{formErrors.userName}</p>
            <br/>


            <label>Password</label>
            <input name="password" type="password" placeholder="Password*" className="username"
            value={formValues.password} onChange={e=>setUser({...formValues,password:e.target.value})}
            />
            <p>{formErrors.password}</p>
            <br/>
            
            <label>Landlord Name</label>
            <input name="landlordname" type="text" placeholder="Landlord Name" className="username"
            value={formValues.landlordName} onChange={e=>setLandlord({...landlord,landlordName:e.target.value})}/>
            <p>{formErrors.landlordName}</p>
            
            <label>Landlord Age</label>
            <input name="landlordeage" type="number" placeholder="Landlord Age" className="username"
            value={formValues.landlordAge} onChange={e=>setLandlord({...landlord,landlordAge:e.target.value})}/>
            <p>{formErrors.landlordAge}</p>
            <br/>
            
            <button className="btn" type="submit" onClick={handleLandlord}>Register Landlord</button>
            </form>
            </div>
        </React.Fragment>
    )
}

export default RegisterLandlord