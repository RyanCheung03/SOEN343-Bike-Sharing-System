import React from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Map from '../../components/Map';

const Home = () => {
    const navigate = useNavigate();

    // Retrieve full name from localStorage
    const fullName = localStorage.getItem('user_full_name');
    const role = localStorage.getItem('user_role');

    const handleLogout = () => {
        try {
            localStorage.removeItem('jwt_token');
            localStorage.removeItem('user_email');
            localStorage.removeItem('user_full_name');
            localStorage.removeItem('user_role');
            delete axios.defaults.headers.common['Authorization'];
        } finally {
            // Navigate to login page and trigger auth logout handling if present
            navigate('/', { replace: true });
        }
    };

    return (
        <div style={{ padding: '16px' }}>
            <header style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
                <h1>Hello{fullName ? `, ${fullName}` : ''}!</h1>
                {role && <p style={{ margin: 0, fontWeight: 500 }}>Role: {role}</p>}

                <button type="button" onClick={handleLogout} style={{padding: '8px 12px', cursor: 'pointer'}}>
                    Logout
                </button>
            </header>

            <main>
                {/* existing home content here */}
                <p>Welcome to the app.</p>
                <Map />
            </main>
        </div>
    );
};

export default Home;