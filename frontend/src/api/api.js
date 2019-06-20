import axios from "axios";

const API_PREFIX = "/api";
const getApiPath = url => `${API_PREFIX}/${url}`;

export const getProjects = () => axios.get(getApiPath("projects"));
