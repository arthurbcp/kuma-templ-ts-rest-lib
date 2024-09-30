{{- define "TypeResolver" -}}
    {{- if .Ref -}}
        {{ .Ref }}
    {{- else if eq .Type "integer" -}}
        number
    {{- else if eq .Type "number" -}}
        number
    {{- else if eq .Type "string" -}}
        {{- if .Enum }}
            {{- range $index, $enumVal := .Enum -}}
                {{- if $index }} | {{ end }}"{{ $enumVal }}"
            {{- end -}}
        {{- else -}}
            string
        {{- end -}}
    {{- else if eq .Type "array" -}}
        {{- block "TypeResolver" .Items }}{{- end -}}[]
    {{- else if eq .Type "object" -}}
        { [key: string]: any }
    {{- else if eq .Type "boolean" -}}
        boolean
    {{- else -}}
        any
    {{- end -}}
{{- end -}}