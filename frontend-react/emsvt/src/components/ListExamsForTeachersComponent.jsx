import React, { Component } from 'react';
import { withNavigation } from './withNavigation';
import ExamService from '../services/ExamService';

class ListExamsForTeachers extends Component {
    constructor(props) {
        super(props);
        
        this.state = {
            examList: []
        }

        this.addExam = this.addExam.bind(this);
        this.editExam = this.editExam.bind(this);
        this.deleteExam = this.deleteExam.bind(this);
    }

    componentDidMount() {
        ExamService.getExams().then( (res) => {
            this.setState( { examList: res.data } );
        });
    }

    addExam() {
        this.props.navigate('/create-exam');
    }

    editExam(id) {
        this.props.navigate(`/update-exam/${id}`);
    }

    deleteExam(id) {
        ExamService.deleteExam(id).then( res => {
            //Optimization: No need for another API call, it will refresh after the next load anyway...
            this.setState( {examList: this.state.examList.filter(examList => examList.id !== id)});
        });
    }
    
    render() {
        return (
            <div>
                <h2 className='text-center'>Exam List</h2>
                <div className='row'>
                    <div className='col-auto'>
                        <button type='button' id='createExamButton' className='btn btn-primary' onClick={ this.addExam }>Add New Exam</button>
                    </div>
                </div>
                <div className='row'>
                    <div className='col-12'>
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                <th>Exam Name</th>
                                <th>Location</th>
                                <th>Lecturer</th>
                                <th>Date</th>
                                <th>Exam Limit</th>
                                <th>Free Space</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.examList.map(
                                    exams => 
                                    <tr key = {exams.id}>
                                        <td> {exams.examName} </td>
                                        <td> {exams.examLocation} </td>
                                        <td> {exams.lecturer} </td>
                                        <td> {exams.examDate} </td>
                                        <td> {exams.examLimit} </td>
                                        <td> {exams.examFreeSpace} </td>
                                        <td>
                                            <button id='actionButtons' className='btn btn-info btn-sm' onClick={ () => this.editExam(exams.id) }>Update</button>
                                            <button id='actionButtons' className='btn btn-danger btn-sm' onClick={ () => this.deleteExam(exams.id) }>Delete</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
            </div>
        );
    }
}

export default withNavigation(ListExamsForTeachers);