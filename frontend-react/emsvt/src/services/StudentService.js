import axios from "axios";

const EXAM_API_BASE_URL = "http://localhost:8080/api/v1/students"

class StudentService {
    
    getRegistrations() {
        return axios.get(EXAM_API_BASE_URL);
    }

    AddRegistration(id, reg) {
        return axios.post(EXAM_API_BASE_URL + '/register/' + id , reg).catch(function (error) {
            console.log(error.response.data);
            console.log(error.response.status);
        })
    }

    deleteRegistration(id) {
        return axios.delete(EXAM_API_BASE_URL + '/' + id);
    }
}

export default new StudentService()