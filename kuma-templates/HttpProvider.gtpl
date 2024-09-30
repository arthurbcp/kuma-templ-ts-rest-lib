import axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from "axios";


export type Server = 
{{- if not .Data.Servers -}}{{ " " }} "" 
{{- else -}}
{{- range $index, $val := .Data.Servers -}}
        {{- if $index }} | {{ end }}"{{ $val.Url }}"
{{- end}}
{{- end}}

export interface IHttpProvider {
  get<T>(url: string, data: HttpProviderData): Promise<AxiosResponse<T>>;
  post<T>(url: string, data: HttpProviderData): Promise<AxiosResponse<T>>;
  put<T>(url: string, data: HttpProviderData): Promise<AxiosResponse<T>>;
  delete<T>(url: string, data: HttpProviderData): Promise<AxiosResponse<T>>;
  patch<T>(url: string, data: HttpProviderData): Promise<AxiosResponse<T>>;
}

export type HttpProviderData = {
  data: any;
  params: any;
  query: any;
  config: AxiosRequestConfig;
};

class HttpProvider implements IHttpProvider {
  private client: AxiosInstance;

  constructor(baseURL: string = "") {
    this.client = axios.create({
      baseURL: baseURL,
      headers: {
        "Content-Type": "application/json",
      },
    });
  }

  private buildUrl(url: string, params: any, query: any): string {
    Object.keys(params).forEach((key) => {
      const regex = new RegExp(`{${key}}`, "g");
      url = url.replace(regex, encodeURIComponent(params[key]));
    });

    const queryString = Object.keys(query)
      .map(
        (key) => `${encodeURIComponent(key)}=${encodeURIComponent(query[key])}`
      )
      .join("&");

    return queryString ? `${url}?${queryString}` : url;
  }

  public get<T>(
    url: string,
    { params, query, config }: HttpProviderData
  ): Promise<AxiosResponse<T>> {
    return this.client.get<T>(this.buildUrl(url, params, query), config);
  }

  public post<T>(
    url: string,
    { data, params, query, config }: HttpProviderData
  ): Promise<AxiosResponse<T>> {
    return this.client.post<T>(this.buildUrl(url, params, query), data, config);
  }

  public put<T>(
    url: string,
    { data, params, query, config }: HttpProviderData
  ): Promise<AxiosResponse<T>> {
    return this.client.put<T>(this.buildUrl(url, params, query), data, config);
  }

  public delete<T>(
    url: string,
    { params, query, config }: HttpProviderData
  ): Promise<AxiosResponse<T>> {
    return this.client.delete<T>(this.buildUrl(url, params, query), config);
  }

  public patch<T>(
    url: string,
    { data, params, query, config }: HttpProviderData
  ): Promise<AxiosResponse<T>> {
    return this.client.patch<T>(
      this.buildUrl(url, params, query),
      data,
      config
    );
  }
}

export default HttpProvider;
