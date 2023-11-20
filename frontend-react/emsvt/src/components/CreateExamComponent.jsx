import React, { Component } from 'react';
import { withNavigation } from './withNavigation';
import ExamService from '../services/ExamService';

class CreateExamComponent extends Component {
    constructor(props) {
        super(props);
        
        this.state = {
            examName: '',
            location: '',
            lecturer: '',
            examDate: '',
            examLimit: '',
            freeSpace: '',
        }

        this.changeExamName = this.changeExamName.bind(this);
        this.changeLocation = this.changeLocation.bind(this);
        this.changeLecturer = this.changeLecturer.bind(this);
        this.changeDate = this.changeDate.bind(this);
        this.changeExamLimit = this.changeExamLimit.bind(this);
        this.saveExam = this.saveExam.bind(this);
        this.cancel = this.cancel.bind(this);
    }

    saveExam = (e) => {
        e.preventDefault();
        let exam = {examName: this.state.examName, examLocation: this.state.location, lecturer: this.state.lecturer, examDate: this.state.examDate, examLimit: this.state.examLimit, examFreeSpace: this.state.examLimit};
        console.log('exam => ' + JSON.stringify(exam));

        ExamService.addExam(exam).then( res => {
            this.props.navigate('/examListTeachers');
        })
    }

    cancel() {
        this.props.navigate('/');
    }

    changeExamName = (event) => {
        this.setState( {examName: event.target.value} );
    }

    changeLocation = (event) => {
        this.setState( {location: event.target.value} );
    }

    changeLecturer = (event) => {
        this.setState( {lecturer: event.target.value} );
    }

    changeDate = (event) => {
        this.setState( {examDate: event.target.value} );
    }

    changeExamLimit = (event) => {
        this.setState( {examLimit: event.target.value} );
        this.setState( {freeSpace: event.target.value} );
    }

    render() {
        return (
            <div>
                <div className='card'>
                    <h5 className='card-header'>Add New Exam</h5>
                    <div className='card-body'>
                        <form>
                            <div className='row'>
                                <div className='col'>
                                    <div className='form-group'>
                                        <label htmlFor='examNameInput'>Exam Name</label>
                                        <input type='text' className='form-control' id='examNameInput' aria-describedby='examNameHelp' placeholder='Enter Exam Name' value={ this.state.examName } onChange={ this.changeExamName }></input>
                                        <small id='examNameHelp' className='form-text text-muted'>Please enter the name of the exam.</small>
                                    </div>
                                </div>
                                <div className='col'>
                                    <div className='form-group'>
                                        <label htmlFor='examLocationInput'>Location</label>
                                        <input type='text' className='form-control' id='examLocationInput' aria-describedby='locationHelp' placeholder='Exam Location' value={ this.state.location } onChange={ this.changeLocation }></input>
                                        <small id='locationHelp' className='form-text text-muted'>Please enter the location of the exam.</small>
                                    </div>
                                </div>
                            </div>
                            <div className='row'>
                                <div className='col'>
                                    <div className='form-group'>
                                        <label htmlFor='lecturerInput'>Lecturer</label>
                                        <input type='text' className='form-control' id='lecturerInput' aria-describedby='lecturerHelp' placeholder='Lecturer' value={ this.state.lecturer } onChange={ this.changeLecturer }></input>
                                        <small id='lecturerHelp' className='form-text text-muted'>Lecturer Name</small>
                                    </div>
                                </div>
                                <div className='col'>
                                    <div className='form-group'>
                                        <label htmlFor='dateInput'>Date</label>
                                        <input type='date' className='form-control' id='dateInput' value={ this.state.examDate } onChange={ this.changeDate }></input>
                                    </div>
                                </div>
                            </div>
                            <div className='row'>
                                <div className='col-md-6'>
                                    <div className='form-group'>
                                        <label htmlFor='examLimitInput'>Registration Limit</label>
                                        <input type='text' className='form-control' id='examLimitInput' aria-describedby='limitHelp' placeholder='0' value={ this.state.examLimit } onChange={ this.changeExamLimit }></input>
                                        <small id='limitHelp' className='form-text text-muted'>Set a max limit for registration.</small>
                                    </div>
                                </div>
                            </div>
                            <div className='row'>
                                <div className='col'>

                                </div>
                                <div className='col'>
                                    <button type='submit' id='actionButtons' className='btn btn-success float-end' onClick={ this.saveExam }>Save Exam</button>
                                    <button type='button' id='actionButtons' className='btn btn-secondary float-end' onClick={ this.cancel }>Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div className='card-footer text-muted'>
                        Last Refreshed: -
                    </div>
                </div>
            </div>
        );
    }
}

export default withNavigation(CreateExamComponent);