import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function ViewAllFlat() {

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
    const URL = `http://localhost:8080/flat/viewallflat`;
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
      <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
      {/* <h1 style={mystyle}>All Flats</h1> */}
      <br/><br/><br/><br/>
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
            {Flat&&Flat.map((flat) => (
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
              </tr>
            ))}
            
          </tbody>
      </table>                          
    </div>
  );
}

export default ViewAllFlat;
