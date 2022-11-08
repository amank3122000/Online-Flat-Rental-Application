import React, { useEffect, useState } from 'react';
import styles from '../Home-Page/home.module.css';
import {Link} from 'react-router-dom';

function Home() {

   return (
      <React.Fragment>
            <div className={styles.cont}>
            <div className={styles.coch1}>
                <h1>Hello !</h1>
                <p>Welcome to the Online Flat Rental Web Portal. To know more...</p>
                <Link to="/login" className="btn btn-primary btn-lg">Get Started &gt;&gt;&gt;</Link>
            </div>
        </div>
      </React.Fragment>
    );
}

export default Home;