import React, { Component } from 'react';
import { withNavigation } from './withNavigation';
import { useLocation } from 'react-router-dom';
import { withRouter } from 'react-router-dom'

class CreateExamComponent extends Component {
    constructor(props) {
        super(props);
        
        this.state = {

        }
    }
    
    render() {
        const { location } = this.props;
        return (
            <div>
                <div className='modal fade' tabIndex='-1' role='dialog'>
                    <div className='modal-dialog' role='document'>
                          <div className='modal-content'>
                            <div className='modal-header'>
                                <h5 className='modal-title'>Register a new Exam</h5>
                            </div>
                            <div className='modal-body'>
                                <p>Modal form will go here</p>
                            </div>
                            <div className='modal-footer'>
                                <button type='button' className='btn btn-secondary' data-dismiss='modal'>Close</button>
                                <button type='button' className='btn btn-primary'>Save Exam</button>
                            </div>
                          </div>
                    </div>
                </div>
                {location.pathname === '/create-exam' && <Modal />}
            </div>
        );
    }
}

export default withNavigation(withRouter(CreateExamComponent));