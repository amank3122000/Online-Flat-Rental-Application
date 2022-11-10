import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllFlat() {

    /*let initialCustomers=[];
    let [flats,setFlats]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/flat/viewallflat';
        axios.get(URL).then((response) => {
            setFlats(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

    function goToAddCustomer(){
        //props.history.push('/addCustomer');
    }


  return (
      <React.Fragment>
            <table class="table table-data table-striped table-bordered">
    <thead>
        <tr class="table-warning">
          <th class="col-md-1">Flat ID</th>
          <th class="col-md-2">Flat Cost</th>
          <th class="col-md-5">Flat Address</th>
          <th class="col-md-1">Flat Availability</th>
          <th class="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody class="table-success ">
      {
      flats.map (

                    flat =>

        <tr>
          <td class="col-md-1">{flat.flatId}</td>
          <td class="col-md-2">{flat.flatCost}</td>
          <td class="col-md-5">Some address</td>    
          <td class="col-md-1">{flat.flatAvailability}</td>
          <td class="col-md-3">
            <button class="btn btn-warning logout-btn" type="submit">Update</button>
            <button class="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
      )}
      </tbody>
      </table>
    </React.Fragment>
    );*/


    let initialFlat = [] ;
  let [Flat, setFlat] = useState(initialFlat);

  const formStyle = {
    backgroundColor: "#FFFAFA",
    padding: "15px"
};
const mystyle = {
    color: "white",
    backgroundColor: "DodgerBlue",
    padding: "10px",
    fontFamily: "Arial",
  };

  useEffect(() => {
    const URL = "http://localhost:8080/flat/viewallflat";
    axios
      .get(URL)
      .then((response) => {
          setFlat(response.data)
          console.log(response.data)
      })
      .catch((error) => console.log(error.message));
  },[])

//   function handleBookFlat(flat_id){
      
//        const URL = `http://localhost:9000/api/booking/${bookingId}`;
//        axios
//          .delete(URL)
//          .then((response) => {
//              console.log(response.data)
//           })
//     }
  return (
    <div style={formStyle}>
      {/* <h1 style={mystyle}>All Flats</h1> */}
      <table className="table table-hover table-striped border-dark">
        <thead>
          <tr className="table-dark">
            <th>Flat ID</th>
            <th>HOUSE NO</th>
            <th>STREET</th>
            <th>CITY</th>
            <th>PIN</th>
            <th>STATE</th>
            <th>COUNTRY</th>
            <th>FLAT COST</th>
            <th>AVAILABILITY</th>
          </tr>
          </thead>
          
          <tbody>
            {Flat.map((flat) => (
              <tr>
                <td>{flat.flatId}</td>
                <td>{flat.flatAddress.houseNo}</td>
                <td>{flat.flatAddress.street}</td>
                <td>{flat.flatAddress.city}</td>
                <td>{flat.flatAddress.pin}</td>
                <td>{flat.flatAddress.state}</td>
                <td>{flat.flatAddress.country}</td>
                <td>{flat.cost}</td>
                <td>{flat.availability}</td>
                {/* <td><button className="btn btn-outline-danger" onClick={()=>handleDeleteOrder(flat.bookingId)}>Delete</button></td> */}
              </tr>
            ))}
            
          </tbody>
        
      </table>
      {/* <div className="col-15 container">
                                    <button type="submit" onClick ={handleSubmit} className="btn btn-primary mt-3">BOOK NOW</button>
                                </div> */}
                                
    </div>
  );


}

export default ViewAllFlat;
