import React, { Component } from 'react';
import { withNavigation } from './withNavigation';
import StudentService from '../services/StudentService';

class ListRegistrationsForStudentsComponent extends Component {
    constructor(props) {
        super(props);
         this.state = {
            
            regList : []

         }

         this.deleteRegistration = this.deleteRegistration.bind(this);
         this.newReg = this.newReg.bind(this);
    }

    componentDidMount() {
        StudentService.getRegistrations().then( (res) => {
            this.setState( { regList: res.data } );
        });
    }

    newReg() {
        this.props.navigate('/register')
    }

    deleteRegistration() {

    }
    
    render() {
        return (
                <div>
                <h2 className='text-center'>Registration List</h2>
                <div className='row'>
                    <div className='col-auto'>
                        <button type='button' id='NewRegButton' className='btn btn-primary' onClick={ this.newReg }>New Registration</button>
                    </div>
                </div>
                <div className='row'>
                    <div className='col-12'>
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Registered To</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.regList.map(
                                    regs => 
                                    <tr key = {regs.id}>
                                        <td> {regs.studentName} </td>
                                        <td> {regs.registeredTo} </td>
                                        <td>
                                            <button id='actionButtons' className='btn btn-danger btn-sm' onClick={ () => this.deleteRegistration(regs.id) }>Delete</button>
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

export default withNavigation(ListRegistrationsForStudentsComponent);