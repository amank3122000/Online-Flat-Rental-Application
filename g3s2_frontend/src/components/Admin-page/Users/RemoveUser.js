import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveUser() {

   
   const [status, setStatus] = useState(null);
   const [userid,setUserid] = useState(0);
   const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

   useEffect(() => {
      // DELETE request using axios inside useEffect React hook
      axios.delete(`http://localhost:8080/user/removeUser/${userid}`)
      .then(() => setStatus('Delete successful'));
  // empty dependency array means this effect will only run once (like componentDidMount in classes)
  }, [userid]);


  const handleBtnClick = (e)=>{
      console.log(e.target.response)
      setFormErrors(validate(user));
      setIsSubmit(true);
      window.alert("User Removed");
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(userid);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.username) {
        errors.userid = "User id is required!";
    }
    return errors;
  };

   return (
      <React.Fragment>
        <form className="c2 view-form" method="POST">
            <h1 className="form-text ">Remove User By ID</h1>
           <br/>
            <input name="userid" type="number" placeholder="User ID*" className="username" 
             value = {userid}
             onChange={e=>setUserid(e.target.value)}
            />
            <br/>
            <p>{formErrors.userid}</p>
            <button className="btn" onSubmit={handleBtnClick}>Remove User</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveUser; 