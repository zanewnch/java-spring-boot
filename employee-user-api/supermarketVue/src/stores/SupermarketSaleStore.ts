import {defineStore} from 'pinia'
import request from "../utils/Request";
import type {AxiosResponse} from "axios";
import Result from '../utils/Result';
import SupermarketSale from "@/model/entity/SupermarketSale";

// crud: test finished
// todo: for testing, temporarily close the backend interceptor(in interceptor config)
export const useSuperMarketSaleStore = defineStore('superMarketSale', {
        state: (): {
            requestData: Result<SupermarketSale> | null,
            pageNum: number | null,
            pageSize: number | null,
            branchInput: string | null,
            cityInput: string | null,
            customerTypeInput: string | null,
            manipulateData: SupermarketSale | null
        } => {
            return {
                requestData: null,
                pageNum: null,
                pageSize: null,
                branchInput: null,
                cityInput: null,
                customerTypeInput: null,
                manipulateData: null
            }
        },
        getters: {
            // 不像java bean 每一個field 都要有getter setter, 因為pinia store field都是reactive的,不可能設為private(因此不需要getter setter)
            getRequestData(): any {
                return this.requestData
            },

            setRequestData(data: any): void {
                this.requestData = data
            }

        },
        actions: {
            async get(): Promise<void> {
                try {
                    const res: AxiosResponse<Result<SupermarketSale>> = await request.get('/supermarketSale', {
                        params: {
                            pageNum: this.pageNum,
                            pageSize: this.pageSize
                        }
                    })

                    this.requestData = res.data;

                    console.log(this.requestData)
                } catch (e) {
                    console.log(e)
                }
            },

            async create(supermarketSale: SupermarketSale): Promise<void> {
                //
                // const supermarketSale: SupermarketSale = new SupermarketSale(
                //     null, branch, city, customerType, gender, productLine, unitPrice, quantity, tax5Percent, total, date, time, payment, cogs, grossMarginPercentage, grossIncome, rating
                // );

                try {
                    const res = await request.post('/supermarketSale', supermarketSale, {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });
                } catch (e) {
                    console.log(e);
                }
            },
            async update(supermarketSale:SupermarketSale): Promise<void> {
                // const supermarketSale: SupermarketSale = new SupermarketSale(
                //     null, branch, city, customerType, gender, productLine, unitPrice, quantity, tax5Percent, total, date, time, payment, cogs, grossMarginPercentage, grossIncome, rating
                // );
                try {
                    const res = await request.put('/supermarketSale', supermarketSale, {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });
                } catch (e) {
                    console.log(e);
                }
            },
            async delete(id: number): Promise<void> {
                try {

                    const res = await request.delete(`/supermarketSale/${id}`);

                } catch (e) {
                    console.error('Error deleting sale:', e);
                }

            },


        }
    }
)