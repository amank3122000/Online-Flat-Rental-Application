import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function ViewUser() {

    const [userid,setUserid] = useState(0);
    const [userDetails,setUserDetail] = useState([]);
    const [btn,setButton] = useState(0);
    const [deletebtn,setdeleteButton] = useState(0);
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

 
    useEffect(() => {
       axios.get(`http://localhost:8080/users/viewUser/${userid}`)
       .then((response) => {
        setUserDetail(response.data)
        setUserid(0);}).catch(error => console.log(error.message));
   }, [btn]);

        useEffect(()=>{
            const URL=`http://localhost:8080/users/removeUser/${userid}`
            axios.delete(URL).then(response=>
                {
                    setUserDetail([]);
                    setUserid(0);
                    btn(0);
                }).catch(error=>console.log(error.response));
        },[deletebtn]);


 
 
   const handleBtnClick = (e)=>{
    e.preventDefault();
    setFormErrors(validate(userid));
    setIsSubmit(true);
    setButton(userid)
      
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(userid);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.userid = "User id is required!";
    }
    return errors;
  };

  const handleDeleteBtnClick =(e)=>{
      e.preventDefault();
      setdeleteButton(userid)
  }


   return (
      <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
            <form className="view-form"> 
                <h1 className="form-text ">View User By ID</h1>
                <br/>
                <label>User Id</label>
                <input name="userId" type="number" placeholder="User ID*" className="username"
                  value = {userid}
                  onChange={e=>setUserid(e.target.value)}
                
                />
                <p>{formErrors.userid}</p>
                <br/>
                <button className="btn" onClick={handleBtnClick}>View User</button>
            </form>
            
        
            <table className="table table-data table-striped table-bordered view-table">
            <thead>
                <tr className="table-warning">
                <th className="col-md-2">User ID</th>
                <th className="col-md-4">User Name</th>
                <th className="col-md-4">User Type</th>
                <th className="col-md-2">Actions</th>
                </tr>
            </thead>
            <tbody className="table-success ">
            
                    <tr>
                        <td className="col-md-2">{userDetails.userId}</td>
                        <td className="col-md-3">{userDetails.userName}</td>
                        <td className="col-md-3">{userDetails.userType}</td>
                        <td className="col-md-3">
                    <button className="btn btn-warning logout-btn" type="submit">Update</button>
                    <button className="btn btn-danger logout-btn" type="submit" 
                     onClick={handleDeleteBtnClick}
                    >Delete</button>
                </td>
                </tr>
                 
            </tbody>
            </table>
      </React.Fragment>
    );
}

export default ViewUser;