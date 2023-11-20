import React, { Component } from 'react';
import { withNavigation } from './withNavigation';
import teacherImage from '../assets/teacher.jpg';
import studentImage from '../assets/student.jpg';

class MainpageComponent extends Component {
    constructor(props) {
        super(props);
        
        this.state = {

        }

        this.toTeacherSite = this.toTeacherSite.bind(this);
        this.toStudentSite = this.toStudentSite.bind(this);
    }

    toTeacherSite() {
        this.props.navigate('/examListTeachers');
    }

    toStudentSite() {
        this.props.navigate('/examListStudents')
    }
    
    render() {
        return (
/*             <div>
                <button type='button' className='btn btn-primary' onClick={ () => this.toTeacherSite() }>I am a Teacher</button>
                <button type='button' className='btn btn-primary' onClick={ () => this.toStudentSite() }>I am a Student</button>
            </div> */
            <div className='row'>
                <div className='col-md-6'>
                    <div className='card'>
                        <img className='card-img-top' src={ teacherImage }></img>
                        <div className='card-body'>
                            <div className='d-flex justify-content-center'>
                                <button type='button' id='loginButton' className='btn btn-primary' onClick={ () => this.toTeacherSite() }>I am a Teacher</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div className='col-md-6'>
                    <div className='card'>
                        <img className='card-img-top' src={ studentImage }></img>
                        <div className='card-body'>
                           <div className='d-flex justify-content-center'>
                                <button type='button' id='loginButton' className='btn btn-primary float-center' onClick={ () => this.toStudentSite() }>I am a Student</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        );
    }
}

export default withNavigation(MainpageComponent);