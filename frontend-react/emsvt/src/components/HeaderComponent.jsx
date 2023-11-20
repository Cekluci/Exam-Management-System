import React, { Component } from 'react';
import { withNavigation } from './withNavigation';

class HeaderComponent extends Component {
    constructor(props) {
        super(props);
        
        this.state = {

        }

        this.goHome = this.goHome.bind(this);
    }
    
    goHome() {
        this.props.navigate('/');
    }
    
    render() {
        return (
            <div>
                <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                    <div><a href="https://github.com/Cekluci/Exam-Management-System" className='navbar-brand'>Exam Management System</a></div>
                    <div className='collapse navbar-collapse' id='navbarSupportedContent'>
                        <ul className='navbar-nav mr-auto'>
                            <li className='nav-item active'>
                                <a className='nav-link' role='button' onClick={ () => this.goHome() }>Home</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        );
    }
}

export default withNavigation(HeaderComponent);