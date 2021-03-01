import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue'
import BestSellerList from '@/components/BestSellerList.vue'
import NewReleasesList from '@/components/NewReleasesList.vue'
import ReadingList from '@/components/ReadingList.vue'
import BookCard from '@/components/BookCard.vue'
import NewBook from '@/views/NewBook.vue'

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
    path: '/book/$this.store.isbn',
    name: 'book-details',
    component: BookCard
  }
  

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
