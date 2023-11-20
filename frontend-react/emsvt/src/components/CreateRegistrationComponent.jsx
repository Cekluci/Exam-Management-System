import React, { Component } from 'react';
import { withNavigation } from './withNavigation';

class CreateRegistrationComponent extends Component {

    constructor(props) {
        super(props);
        
        this.state = {
            studentName: '',
            registeredTo: ''
        }
    }
    
    render() {
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
                                        <select className='form-control' id='examSelector' aria-describedby='examSelectorHelp'>
                                            <option>1</option>
                                            <option>2</option>
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