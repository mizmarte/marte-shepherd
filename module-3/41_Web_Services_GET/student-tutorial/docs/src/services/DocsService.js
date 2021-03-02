import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
});

//list method uses axios to call documents web api and return a promise
export default {
    list() {
        return http.get('/docs');
    },
    get(id) {
        return http.get(`/docs/${id}`)
    }
}