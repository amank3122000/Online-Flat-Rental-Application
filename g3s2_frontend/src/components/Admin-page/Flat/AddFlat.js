import React ,{useState,useEffect} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';

function AddFlat() {

    let initialFlat={
        flatAddress:{
            houseNo:0,
            street:'',
            city:'',
            state:'',
            pin:0,
            country:''
            },
        availability:'',
        cost:0,
        flatId:0,
        landlord:{landlordId:0}

        }
    let [Flat,setFlat]=useState(initialFlat)
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    let [msg,setMsg]=useState('')
    let [id,setId]=useState(0)

    const validate = (values) => {
        const errors = {};
        if (!values.flatId) {
            errors.flatId = "Flat Id is required!";
          }
        if (!values.houseNo) {
          errors.houseNo = "House No is required!";
        }
        // if (!values.street) {
        //     errors.street = "Street is required!";
        //   }
        // if (!values.city) {
        //     errors.city = "City is required!";
        //   }
        // if (!values.state) {
        //     errors.state = "State is required!";
        //   }
        // if (!values.pin) {
        //     errors.pin = "PIN is required!";
        //   }
        // if (!values.country) {
        //     errors.country = "Country is required!";
        //   }
        if (!values.availability) {
          errors.availability = "Availability is required!";
        } 
        if (!values.cost) {
          errors.cost = "Cost is required!";
        } 
        else if (values.cost < 1000) {
          errors.cost = "Cost must be more than 1000!";
        } 
        return errors;
      };

    function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(Flat));
      setIsSubmit(true);
      const URL='http://localhost:8080/flat/addflat';
      axios.post(URL,Flat).then((response) => 
      {
          window.alert("Flat Added...");
          setFlat(initialFlat);
      }).catch(error => console.log(error.message))
      
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(Flat);
    }
  }, [formErrors]);

    // useEffect(()=>
    // {
    //     const URL=`http://localhost:8080/flat/addflat`
    //     axios.post(URL,Flat).then(response=>
    //         {
    //             setMsg(response.data)
    //             setId(0);
    //         }).catch(error=>console.log(error.response))
    // },[id])


//    const handleBtnClick=(event)=>
//     {
//         event.preventDefault()
//         setId(1)
        
//     }
    return (
        <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
      
      
      <form className="c2" method="POST">
    <h1 className="form-text ">Add Flat</h1>
    <br/>

    {/* <label>Flat Id</label>
       <input name="flatid" type="number" placeholder="Flat ID" className="username" 
       value={Flat.flatId} onChange={e=>setFlat({...Flat,flatId:e.target.value})}
       />
       <p>{formErrors.flatId}</p> */}
       
            <label>House No</label>
       <input name="flatid" type="number" placeholder="House No" className="username" 
       value={Flat.flatAddress.houseNo} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,houseNo:e.target.value}})}
       />
       <p>{formErrors.houseNo}</p>

       {/* <label>Landlord Id</label>
       <input name="landlordid" type="number" placeholder="Landlord Id" className="username" 
       value={Flat.landlord.landlordId} onChange={e=>setFlat({...Flat,landlord:{...Flat.landlord,landlordId:e.target.value}})}
       />
       <p>{formErrors.houseNo}</p> */}

            <label>Cost</label>
       <input name="flatid" type="number" placeholder="Cost" className="username" 
       value={Flat.cost} onChange={e=>setFlat({...Flat,cost:e.target.value})}
       />
       <p>{formErrors.cost}</p>

       <label>Availability</label>
        <select name="availability" className="username"
        value={Flat.availability} onChange={e=>setFlat({...Flat,availability:e.target.value})}
        >
          <option value="">Availability*</option>
          <option value="available">Available</option>
          <option value="unavailable">Unavailable</option>
         </select>
         <p>{formErrors.availability}</p>
         <br/>

         <button className="btn" data-testid="button" onClick={handleBtnClick}>Add Flat</button>
      
      </form>

        </React.Fragment>
    )
}

export default AddFlat;
