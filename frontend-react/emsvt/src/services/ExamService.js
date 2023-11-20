import axios from 'axios';
const EXAM_API_BASE_URL = "http://localhost:8080/api/v1/exams"

class ExamService {
    getExams() {
        return axios.get(EXAM_API_BASE_URL);
    }

    addExam(exam) {
        return axios.post(EXAM_API_BASE_URL, exam)
    }

    getExamById(examId) {
        return axios.get(EXAM_API_BASE_URL + '/' + examId)
    }

    updateExam(exam, examId) {
        return axios.put(EXAM_API_BASE_URL + '/' + examId, exam);
    }

    deleteExam(examId) {
        return axios.delete(EXAM_API_BASE_URL + '/' + examId)
    }
}

export default new ExamService()