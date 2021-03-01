import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue'
import BestSellerList from '@/components/BestSellerList.vue'
import NewReleasesList from '@/components/NewReleasesList.vue'
import ReadingList from '@/components/ReadingList.vue'
import BookCard from '@/components/BookCard.vue'
import NewBook from '@/views/NewBook.vue'
import BookDetails from '@/views/BookDetails.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/best-seller-list',
    name: 'best-seller-list',
    component: BestSellerList
  },
  {
    path: '/new-releases-list',
    name: 'new-releases-list',
    component: NewReleasesList
  },
  {
    path: '/myBooks',
    name: 'reading-list',
    component: ReadingList
  },
  {
    path: '/book-card',
    name: 'book-card',
    component: BookCard
  },
  {
    path: '/addBook',
    name: 'new-book',
    component: NewBook
  },
  {
    path: '/book/:isbn',
    name: 'book-details',
    component: BookDetails
  }
  

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
