import React, { Component, useState, useEffect } from 'react';
import { withNavigation } from './withNavigation';
import ExamService from '../services/ExamService';
import StudentService from '../services/StudentService';


class CreateRegistrationComponent extends Component {

    constructor(props) {
        super(props);
        
        this.state = {
            examList: [],
            studentName: '',
            registeredTo: 'Analizis',
            examId: '1',
            errorMessage: ''
        }

        this.saveReg = this.saveReg.bind(this);
        this.cancel = this.cancel.bind(this);
        this.changeStudentName = this.changeStudentName.bind(this);
        this.changeExamList = this.changeExamList.bind(this);
    }

/*     componentDidMount() {
        ExamService.getDistinctExams().then( (res) => {
            this.setState( { examList: res.data });
        });

        console.log(this.state.examList);
    } */

    componentDidMount() {
        ExamService.getDistinctExams().then( (res) => {
            this.setState( { examList: res.data }, () => {
                console.log(this.state.examList);
            });
        });
    }

    changeStudentName = (event) => {
        this.setState( {studentName: event.target.value} );
    }

    changeExamList = (event) => {
        const selectedExam = event.target.value;
        const selectedExamId = this.state.examList.find(exam => exam.examName.toString() === selectedExam);

        this.setState( {registeredTo: selectedExam} );
        this.setState( {examId: selectedExamId.examId} );

    }

/*     saveReg = (e) => {
        e.preventDefault();
        console.log( this.state.studentName );
        console.log( this.state.registeredTo );
        console.log( this.state.examId );

        let reg = {studentName: this.state.studentName, registeredTo: this.state.registeredTo, examId: this.state.examId};
        console.log('reg =>' + JSON.stringify(reg));

        StudentService.AddRegistration(this.state.examId, reg).then( res => {
            this.props.navigate('/examListStudents');
        });
    } */

    saveReg = (e) => {
        e.preventDefault();
        console.log( this.state.studentName );
        console.log( this.state.registeredTo );
        console.log( this.state.examId );

        let reg = {studentName: this.state.studentName, registeredTo: this.state.registeredTo, examId: this.state.examId};
        console.log('reg =>' + JSON.stringify(reg));

        StudentService.AddRegistration(this.state.examId, reg).then( res => {
            this.props.navigate('/examListStudents');
        })
        .catch(error => {
            if (error.response && error.response.status === 409) {
                this.setState({
                    errorMessage: 'No more free spaces available for this exam.'
                });
            } else {
                this.setState({
                    errorMessage: 'An error occured during the registration process. Please try again later.'
                });
            }
        });
    }

    cancel() {
        this.props.navigate('/examListStudents');
    }
    render() {
        const { errorMessage } = this.state;
        return (
            <div>
                <div className='card'>
                    <h5 className='card-header'>Register to Exam</h5>
                    <div className='card-body'>
                        <form>
                            <div className='row'>
                                <div className='col'>
                                    <div className='form-group'>
                                        <label htmlFor='studentNameInput'>Name</label>
                                        <input type='text' className='form-control' id='studentNameInput' aria-describedby='studentNameHelp' placeholder='Name' value={ this.state.studentName } onChange={ this.changeStudentName }></input>
                                        <small id='studentNameHelp' className='form-text text-muted'>Please state your Full Name</small>
                                    </div>
                                </div>
                                <div className='col'>
                                    <div className='form-group'>
                                        <label htmlFor='examSelector'>Select Exam</label>
                                        <select value= { this.state.registeredTo } onChange={ this.changeExamList } className='form-control' id='examSelector' aria-describedby='examSelectorHelp'>
                                            {this.state.examList.map((exam) => (
                                                <option key={ exam.examId } value={ exam.examName }>{ exam.examName }</option>
                                            ))}
                                        </select>
                                        <small id='examSelectorHelp' className='form-text text-muted'>Please select Exam from the list.</small>
                                    </div>
                                </div>
                            </div>
                            <div className='row'>
                                <div className='col'>

                                </div>
                                <div className='col'>
                                    <button type='submit' id='actionButtons' className='btn btn-success float-end' onClick={ this.saveReg }>Register</button>
                                    <button type='button' id='actionButtons' className='btn btn-secondary float-end' onClick={ this.cancel }>Cancel</button>
                                </div>
                            </div>
                        </form>
                        { errorMessage && <div className='error-message'>{ errorMessage }</div> }
                    </div>
                    <div className='card-footer text-muted'>
                        Last Refreshed: -
                    </div>
                </div>
            </div>
        );
    }
}

export default withNavigation(CreateRegistrationComponent);