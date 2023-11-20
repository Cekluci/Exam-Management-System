import axios from "axios";

const EXAM_API_BASE_URL = "http://localhost:8080/api/v1/students"

class StudentService {
    
    getRegistrations() {
        return axios.get(EXAM_API_BASE_URL);
    }
}

export default new StudentService()